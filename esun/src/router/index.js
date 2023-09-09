import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    {
        path: '/',
        component: () => import('../components/HomePage.vue'),
    },
    {
        path: '/user-vote',
        component: () => import('../components/UserVote.vue'),
    },
    {
        path: '/admin',
        component: () => import('../components/AdminPanel.vue'),
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;