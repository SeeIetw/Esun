<template>
    <div class="vote-container">
        <h2>投票表單</h2>
        <form @submit.prevent="submitForm">
            <div class="voter-input">
                <label for="voter">投票者:</label>
                <input type="text" id="voter" v-model="userName" placeholder="請輸入英文名字">
                <span class="warning">{{ errorMsg }}</span>
            </div>

            <table>
                <thead>
                <tr>
                    <th>項目名稱</th>
                    <th>當前票數</th>
                    <th>投票</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in items" :key="item.termId">
                    <td>{{ item.termName }}</td>
                    <td>{{ item.sum }}</td>
                    <td><input type="checkbox" :value="item.termId" v-model="selectedItems"></td>
                </tr>
                </tbody>
            </table>

            <button type="submit">提交</button>
        </form>
    </div>
</template>

<script>
import axios from "axios";

export default {
    data() {
        return {
            userName: "",
            selectedItems: [],
            items: [],
            errorMsg: ""
        };
    },
    created() {
        this.getTermsAndSum();
    },
    methods: {
        async submitForm() {
            try {
                const response = await axios.post('/records',
                    this.selectedItems.map(term => ({ userName: this.userName, termId: term }))
                );
                if(response.data.code===400){
                    this.errorMsg = response.data.msg;
                }else{
                    alert(response.data.msg);
                }
                if(response.data.code===200){
                    window.location.reload();
                }
            } catch (error) {
                console.error(error);
            }
        },
        async getTermsAndSum() {
            try {
                const response = await axios.get('/records/sum');
                this.items = response.data.data;
            } catch (error) {
                console.error(error);
            }
        }
    }
};
</script>

<style scoped>
.vote-container {
    width: 70%;
    margin: 2em auto;
    font-family: 'Arial', sans-serif;
    border: 1px solid #e5e5e5;
    padding: 1em;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

h2 {
    text-align: center;
    margin-bottom: 1em;
    color: #333;
}

.voter-input {
    margin-bottom: 1em;
}

.warning {
    color: #f44336;
    margin-left: 10px;
    font-size: small;
}

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    padding: 0.5em;
    border: 1px solid #e5e5e5;
    text-align: center;
}

button {
    display: block;
    margin: 1em auto;
    padding: 0.5em 1em;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background-color: #45a049;
}
</style>
