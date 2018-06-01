<template>
    <div style="width: 400px;margin-left: 15%">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="姓名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="昵称" prop="nickName">
                <el-input v-model="ruleForm.nickName"></el-input>
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
            <el-form-item label="照片">
                <el-upload
                        class="avatar-uploader"
                        :action="upUrl"
                        :show-file-list="false"
                        :on-success="handleAvatarSuccess"
                        :before-upload="beforeAvatarUpload">
                    <img v-if="ruleForm.photo" :src="ruleForm.photo" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
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
        name: "UserAdd",
        data: function () {
            return {
                upUrl:urls.upUrl,
                ruleForm: {
                    personId: 0,
                    birthday: '',
                    name: '',
                    id: "",
                    sex: "false",
                    ai: false,
                    userId: 0,
                    nickName: '',
                    personId: '',
                    personGroup: 0,
                    photo:null
                },
                rules: {
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 1, max: 200, message: '长度在 1 到 200 个字符', trigger: 'blur'}
                    ],
                    id: [
                        {required: true, message: '请输入身份证', trigger: 'blur'},
                        {min: 1, max: 18, message: '长度在 1 到 18 个字符', trigger: 'blur'}
                    ],
                    nickName: [
                        {required: true, message: '请输入昵称', trigger: 'blur'},
                        {min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur'}
                    ]

                }
            };
        },
        created: function () {
        },
        methods: {
            back: function () {
                this.$router.push("/home/userlist");
            },
            handleAvatarSuccess(res, file) {
                this.ruleForm.photo = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size/1024/1024<2;
                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG&&isLt2M;
            },
            submitForm: function (formName) {
                var that = this;
                this.$refs[formName].validate(function (valid) {
                    if (valid) {
                        httphelper.authedpostform(urls.user_add_url, that.ruleForm,
                            function (data) {
                                that.back();
                            });
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
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }

    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>