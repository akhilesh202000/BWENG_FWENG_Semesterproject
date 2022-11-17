import { createRouter, createWebHistory } from 'vue-router';

import HomeView from '@/views/HomeView';
import RegisterView from '@/views/RegisterView';
import LoginView from '@/views/LoginView';
import HelpView from '@/views/HelpView';
import ImprintView from '@/views/ImprintView';

const routes = [
   {
      path: '/',
      name: 'home',
      component: HomeView,
   },
   {
      path: '/register',
      name: 'register',
      component: RegisterView,
   },
   {
      path: '/login',
      name: 'login',
      component: LoginView,
   },
   {
      path: '/help',
      name: 'Help',
      component: HelpView,
   },
   {
      path: '/imprint',
      name: 'imprint',
      component: ImprintView,
   },
]

const router = createRouter({
   routes,
   history: createWebHistory(process.env.BASE_URL),
});

export default router;