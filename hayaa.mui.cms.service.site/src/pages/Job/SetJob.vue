<template>
    <div style="width: 100%">
        <el-row>
            <el-col :span="8">
                <div class="content-div bg-purple-light">
                    <div v-for="item in companyData">
                        <el-radio v-model="data.companyId" :label="item.companyId" @change="companyNodeClick">{{
                            item.companyName }}
                        </el-radio>
                    </div>
                </div>
            </el-col>
            <el-col :span="8">
                <div class="content-div">
                    <el-tree :data="departmentData" :props="defaultProps" :default-expand-all="isdefaultexpandall"
                             @node-click="departmentNodeClick" :expand-on-click-node="isexpandonclicknode"
                             ref="dtree"></el-tree>
                </div>
            </el-col>
            <el-col :span="8">
                <div class="content-div bg-purple-light">
                    <el-radio v-model="data.jobId" :label="item.jobId" v-for="item in jobData">{{ item.name }}
                    </el-radio>
                </div>
            </el-col>
        </el-row>
        <el-row justify="center" type="flex">
            <el-col :span="24">
                <div style="width: 100%;padding-top: 10px;text-align: center;">
                    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import httphelper from '../../util/httphelper'
    import urls from '../../urlstatic'

    export default {
        name: "SetJob",
        data: function () {
            return {
                isdefaultexpandall:true,
                isexpandonclicknode:false,
                companyData: [],
                departmentData: [],
                jobData: [],
                data: {
                    companyId: 0,
                    departmentId: 0,
                    jobId: 0,
                    userId: 0
                },
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        },
        created: function () {
            this.data.userId = this.$route.params.id;
            this.getCompany();
        },
        methods: {
            back: function () {
                this.$router.push("/home/userlist");
            },
            getCompany: function () {
                var that = this;
                httphelper.authedpostform(urls.company_list_url, {},
                    function (data) {
                        that.companyData = data;
                    })
            },
            getDepartment: function (id) {
                var that = this;
                that.departmentData=[];
                httphelper.authedpostform(urls.department_list_url, {"companyId": id},
                    function (data) {
                        for (var i = 0; i < data.length; i++) {
                            if (!data[i].parentId) {
                                that.departmentData.push({
                                    id: data[i].departmentId,
                                    label: data[i].title,
                                    children: []
                                });
                                data.splice(i, 1);
                                i = i - 1;
                            }
                        }
                        that.nodeMake(that.departmentData, data);
                    })
            },
            nodeMake: function (treedata, data) {
                var that = this;
                for (var j = 0; j < treedata.length; j++) {
                    for (var i = 0; i < data.length; i++) {
                        if (treedata[j].id == data[i].parentId) {
                            treedata[j].children.push({
                                id: data[i].departmentId,
                                label: data[i].title,
                                children: []
                            });
                            data.splice(i, 1);
                        }
                    }
                    if (data.length > 0)
                        that.nodeMake(treedata[j].children, data);
                }
            },
            getJob: function (id) {
                var that = this;
                httphelper.authedpostform(urls.job_list_url, {"departmentId": id},
                    function (data) {
                        that.jobData = data;
                    })
            },
            companyNodeClick: function () {
                this.getDepartment(this.data.companyId);
            },
            departmentNodeClick: function (data) {
                this.getJob(data.id);
                this.data.departmentId = data.id;
            },
            submitForm: function (formName) {
                var that = this;
                httphelper.authedpostform(urls.job_set_url, that.data,
                    function (data) {
                        that.back();
                    });
            }
        }
    }
</script>

<style scoped>
    .bg-purple-light {
        background: #e5e9f2;
    }
    .content-div{
        margin-top: 10px;
        height: 480px;
        padding-left: 15px;
        padding-top:15px;
        overflow: auto;
        font-size:24px;
        border-bottom:solid 1px;
        border-top:solid 1px;
    }
    .el-button{
        width: 350px;
        height: 50px;
    }
</style>