<template>
    <div>
        <el-row>
            <el-col>
                <el-menu default-active="1-1" class="el-menu-vertical-demo">
                    <el-submenu index="1" style="background:#B3C0D1">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span>企业设置</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="1-1">
                                <router-link to="/home/companylist" class="menuitem">组织管理</router-link>
                            </el-menu-item>
                            <el-menu-item index="1-2">
                                <router-link to="/home/userlist" class="menuitem">人员管理</router-link>
                            </el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                </el-menu>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "LeftMenu"
    }
</script>

<style scoped>
    .menuitem {
        color: black;
        text-decoration: none;
    }
    .menuitem:active {
         text-decoration: none;
    }
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 239px;
        min-height: 600px;
    }
</style>