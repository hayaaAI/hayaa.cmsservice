<template>
    <div style="width: 400px;margin-left: 15%">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="名称" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="可见名称" prop="title">
                <el-input v-model="ruleForm.title"></el-input>
            </el-form-item>
            <el-form-item label="上级Id">
                <el-input v-model="ruleForm.parentId"></el-input>
            </el-form-item>
            <el-form-item label="成立日期">
                <el-date-picker type="date" placeholder="成立日期" v-model="ruleForm.birdthday"
                                style="width: 100%;"></el-date-picker>
            </el-form-item>
            <el-form-item label="备注" >
                <el-input v-model="ruleForm.remark"></el-input>
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
                ruleForm: {
                    departmentId: 0,
                    parentId:null,
                    title: '',
                    name: '',
                    birdthday:'',
                    companyId:0,
                    remark:''
                },
                rules: {
                    name: [
                        {required: true, message: '请输入部门英文名称', trigger: 'blur'},
                        {min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur'}
                    ],
                    title: [
                        {required: false, message: '请输入部门名称', trigger: 'blur'},
                        {min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur'}
                    ]
                }
            };
        },
        created: function () {
            var id = this.$route.params.id;
            this.ruleForm.companyId=this.$route.params.cid;
            if (id>0) {
                this.get(id);
            }
        },
        methods: {
            back: function() {
                this.$router.push("/home/departmentlist/"+this.ruleForm.companyId);
            },
            get: function(id) {
                var that = this;
                httphelper.authedpostform(urls.department_get_url, {"id": id},
                    function (data) {
                        that.ruleForm = {
                            departmentId: data.departmentId,
                            parentId:data.parentId,
                            title: data.title,
                            name: data.name,
                            birdthday:data.birdthday,
                            companyId:data.companyId,
                            remark:data.remark
                        };
                    });
            },
            submitForm: function(formName) {
                var that = this;
                that.ruleForm.birdthday=new Date(that.ruleForm.birdthday);
                this.$refs[formName].validate(function(valid) {
                    if (valid) {
                        if (that.ruleForm.departmentId == 0) {
                            httphelper.authedpostform(urls.department_add_url, that.ruleForm,
                                function (data) {
                                    that.back();
                                });
                        } else {
                            httphelper.authedpostform(urls.department_edit_url, that.ruleForm,
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