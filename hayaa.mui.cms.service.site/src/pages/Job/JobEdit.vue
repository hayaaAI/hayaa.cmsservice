<template>
    <div style="width: 400px;margin-left: 15%">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="名称" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="可见名称" prop="title">
                <el-input v-model="ruleForm.title"></el-input>
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
        name: "JobEdit",
        data: function() {
            return {
                companyId:0,
                ruleForm: {
                    jobId: 0,
                    departmentId:0,
                    title: '',
                    name: ''
                },
                rules: {
                    name: [
                        {required: true, message: '请输入App名称', trigger: 'blur'},
                        {min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur'}
                    ],
                    title: [
                        {required: false, message: '请输入App可见名称', trigger: 'blur'},
                        {min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur'}
                    ]

                }
            };
        },
        created: function () {
            this.companyId= this.$route.params.cid;
            this.ruleForm.departmentId= this.$route.params.did;
            var id = this.$route.params.id;
            if (id>0) {
                this.get(id);
            }
        },
        methods: {
            back: function() {
                this.$router.push("/home/joblist/"+this.companyId+"/"+this.ruleForm.departmentId);
            },
            get: function(id) {
                var that = this;
                httphelper.authedpostform(urls.job_get_url, {"id": id},
                    function (data) {
                        that.ruleForm = {
                            jobId: data.jobId,
                            departmentId:data.departmentId,
                            title: data.title,
                            name: data.name
                        };
                    });
            },
            submitForm: function(formName) {
                var that = this;
                this.$refs[formName].validate(function(valid) {
                    if (valid) {
                        if (that.ruleForm.jobId == 0) {
                            httphelper.authedpostform(urls.job_add_url, that.ruleForm,
                                function (data) {
                                    that.back();
                                });
                        } else {
                            httphelper.authedpostform(urls.job_edit_url, that.ruleForm,
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