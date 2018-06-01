<template>
    <div style="width: 400px;margin-left: 15%">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="企业全名" prop="companyFullName">
                <el-input v-model="ruleForm.companyFullName"></el-input>
            </el-form-item>
            <el-form-item label="企业名称" prop="companyName">
                <el-input v-model="ruleForm.companyName"></el-input>
            </el-form-item>
            <el-form-item label="企业编码" prop="companyCode">
                <el-input v-model="ruleForm.companyCode"></el-input>
            </el-form-item>
            <el-form-item label="注册日期">
                <el-date-picker type="date" placeholder="注册日期" v-model="ruleForm.birdthday"
                                style="width: 100%;"></el-date-picker>
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
        name: "CompanyEdit",
        data: function () {
            return {
                ruleForm: {
                    companyId: 0,
                    companyFullName: '',
                    companyName: '',
                    companyCode: '',
                    birdthday:''
                },
                rules: {
                    companyFullName: [
                        {required: true, message: '请输入企业全名', trigger: 'blur'},
                        {min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur'}
                    ],
                    companyName: [
                        {required: true, message: '请输入企业名称', trigger: 'blur'},
                        {min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur'}
                    ],
                    companyCode: [
                        {required: true, message: '请输入企业编码', trigger: 'blur'},
                        {min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur'}
                    ],
                    birdthday: [
                        {required: true, message: '请输入注册日期', trigger: 'blur'}
                    ]

                }
            };
        },
        created: function () {
            var id = this.$route.params.id;
            if (id > 0) {
                this.get(id);
            }
        },
        methods: {
            back: function () {
                this.$router.push("/home/companylist");
            },
            get: function (id) {
                var that = this;
                httphelper.authedpostform(urls.company_get_url, {"id": id},
                    function (data) {
                        that.ruleForm ={
                            companyId: data.companyId,
                            companyFullName: data.companyFullName,
                            companyName: data.companyName,
                            companyCode: data.companyCode,
                            birdthday:data.birdthday
                        }
                    });
            },
            submitForm: function (formName) {
                var that = this;
                that.ruleForm.birdthday=new Date(that.ruleForm.birdthday);
                this.$refs[formName].validate(function (valid) {
                    if (valid) {
                        if (that.ruleForm.companyId == 0) {
                            httphelper.authedpostform(urls.company_add_url, that.ruleForm,
                                function (data) {
                                    that.back();
                                });
                        } else {
                            httphelper.authedpostform(urls.company_edit_url, that.ruleForm,
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
            resetForm: function (formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>