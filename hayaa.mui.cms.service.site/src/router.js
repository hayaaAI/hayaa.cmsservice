import VueRouter from 'vue-router'
import Login from './components/Login.vue'
import Main from './components/Main.vue'
import Index from './pages/Index.vue'
import Message from './pages/Message.vue'
import CompanyList from './pages/Company/CompanyList.vue'
import CompanyEdit from './pages/Company/CompanyEdit.vue'
import CompanyInfo from './pages/Company/CompanyInfo'
import DepartmentList from './pages/Department/DepartmentList.vue'
import DepartmentEdit from './pages/Department/DepartmentEdit.vue'
import JobList from './pages/Job/JobList.vue'
import JobEdit from './pages/Job/JobEdit.vue'
import SetJob from './pages/Job/SetJob.vue'
import PersonEdit from './pages/Person/PersonEdit.vue'
import UserList from './pages/User/UserList.vue'
import UserAdd from './pages/User/UserAdd.vue'
import UserEdit from './pages/User/UserEdit.vue'

const router = new VueRouter({
    mode: 'history',
    routes: [{path: '/login', component: Login},
        {
            path: '/home',
            component: Main,
            children: [
                {path: "index", component: Index},
                {path: "message", component: Message},
                {path: "companylist", component: CompanyList},
                {path: "companyedit/:id?", component: CompanyEdit},
                {path: "companyinfo/:id", component: CompanyInfo},
                {path: "departmentlist/:cid", component: DepartmentList},
                {path: "departmentedit/:cid/:id?", component: DepartmentEdit},
                {path: "joblist/:cid/:did", component: JobList},
                {path: "jobedit/:cid/:did/:id?", component: JobEdit},
                {path: "setjob/:id", component: SetJob},
                {path: "personedit/:cid/:did/:id?", component: PersonEdit},
                {path: "userlist/", component: UserList},
                {path: "useradd/", component: UserAdd},
                {path: "useredit/:id", component: UserEdit}
            ]
        }
    ]
})
export default router