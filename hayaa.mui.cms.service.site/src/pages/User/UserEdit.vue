<template>
    <div style="width: 400px;margin-left: 15%">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="昵称" prop="nickName">
                <el-input v-model="ruleForm.nickName"></el-input>
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
        name: "UserEdit",
        data: function () {
            return {
                upUrl:urls.upUrl,
                ruleForm: {
                    userId: 0,
                    nickName: '',
                    personId: '',
                    personGroup: 0,
                    photo: null
                },
                rules: {
                    nickName: [
                        {required: true, message: '请输入昵称', trigger: 'blur'},
                        {min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur'}
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
                this.$router.push("/home/userlist");
            },
            get: function (id) {
                var that = this;
                httphelper.authedpostform(urls.user_get_url, {"id": id},
                    function (data) {
                        that.ruleForm = {
                            userId: data.userId,
                            nickName: data.nickName,
                            personId: data.personId,
                            personGroup: data.personGroup,
                            photo: data.photo
                        };
                    });
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
                        httphelper.authedpostform(urls.user_edit_url, that.ruleForm,
                            function (data) {
                                if (data)
                                    that.$notify.success("操作成功");
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
        border:solid 1px;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {

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