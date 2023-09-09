<template>
    <div class="container">
        <h1 class="title">線上投票系統</h1>
        <div class="buttons">
            <router-link class="btn" to="/user-vote">使用者投票</router-link>
            <router-link class="btn" to="/admin">後台管理</router-link>
        </div>
    </div>
</template>

<script>
export default {

};
</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

.title {
    margin-bottom: 20px;
}

.buttons {
    display: flex;
    gap: 10px;
}

.btn {
    padding: 10px 20px;
    background-color: #333;
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #555;
}
</style>