<template>
    <div style="width: 400px;margin-left: 15%">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="姓名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-radio-group v-model="ruleForm.sex">
                    <el-radio label="false">男</el-radio>
                    <el-radio label="true">女</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="生日">
                <el-date-picker type="date" placeholder="生日" v-model="ruleForm.birdthday"
                                style="width: 100%;"></el-date-picker>
            </el-form-item>
            <el-form-item label="身份证" prop="id">
                <el-input v-model="ruleForm.id"></el-input>
            </el-form-item>
            <el-form-item label="AI员工">
                <el-switch v-model="ruleForm.ai"></el-switch>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
                <el-button @click="back">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import httphelper from '../../util/httphelper'
    import urls from '../../urlstatic'

    export default {
        name: "DepartmentEdit",
        data: function() {
            return {
                companyId:0,
                departmentId:0,
                ruleForm: {
                    personId: 0,
                    birthday: '',
                    name: '',
                    id:"",
                    sex:"false",
                    ai:false
                },
                rules: {
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 1, max: 200, message: '长度在 1 到 200 个字符', trigger: 'blur'}
                    ],
                    id: [
                        {required: true, message: '请输入身份证', trigger: 'blur'},
                        {min: 1, max: 18, message: '长度在 1 到 18 个字符', trigger: 'blur'}
                    ]

                }
            };
        },
        created: function () {
            var id = this.$route.params.id;
            this.companyId= this.$route.params.cid;
            this.departmentId= this.$route.params.did;
            if (id>0) {
                this.get(id);
            }
        },
        methods: {
            back: function() {
                this.$router.push("/home/companyinfo/"+this.companyId);
            },
            get: function(id) {
                var that = this;
                httphelper.authedpostform(urls.person_get_url, {"id": id},
                    function (data) {
                        that.ruleForm = {
                            personId: data.personId,
                            birthday: data.birthday,
                            name: data.name,
                            id:data.id,
                            sex:data.sex.toString(),
                            ai:data.ai
                        };
                    });
            },
            submitForm: function(formName) {
                var that = this;
                this.$refs[formName].validate(function(valid) {
                    if (valid) {
                        if (that.ruleForm.personId == 0) {
                            httphelper.authedpostform(urls.person_add_url, that.ruleForm,
                                function (data) {
                                    that.back();
                                });
                        } else {
                            httphelper.authedpostform(urls.person_edit_url, that.ruleForm,
                                function (data) {
                                    if (data)
                                        that.$notify.success("操作成功");
                                });
                        }
                    } else {
                        return false;
                    }
                });
            },
            resetForm: function(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>