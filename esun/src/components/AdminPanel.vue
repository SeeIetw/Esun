<template>
    <div class="container">
        <h2>可投票項目</h2>
        <div>
            <input v-model="newItem" placeholder="新增項目"/>
            <button @click="addItem">新增</button>
        </div>
        <ul>
            <li v-for="item in items" :key="item.termId">
                {{ item.termName }}
                <button @click="removeItem(item.termId)">刪除</button>
            </li>
        </ul>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: 'AdminPanel',
    data() {
        return {
            items: [],
            newItem: ''
        };
    },
    created() {
        this.getTerms();
    },
    methods: {
        async addItem() {
            try {
                const response = await axios.post('/terms', { termName: this.newItem });
                alert(response.data.msg);
                window.location.reload();
            } catch (error) {
                console.error(error);
            }
        },
        async removeItem(termId) {
            try {
                const response = await axios.delete('/terms',{
                    data: {
                        termId: termId
                    }
                });
                alert(response.data.msg);
                await this.getTerms();
            } catch (error) {
                console.error(error);
            }
        },
        async getTerms() {
            try {
                const response = await axios.get('/terms');
                this.items = response.data.data;
            } catch (error) {
                console.error(error);
            }
        },
    }
};
</script>

<style scoped>
.container {
    width: 60%;
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

ul {
    list-style-type: none;
    padding: 0;
}

li {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0.5em 0;
    border-bottom: 1px solid #e5e5e5;
}

button {
    padding: 0.5em 1em;
    border: none;
    border-radius: 5px;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.2s ease-in-out;
}

button:hover {
    background-color: #555;
}

button:active {
    transform: scale(0.95);
}

/* Delete Button */
li > button {
    background-color: #f44336;
}

/* Add Button */
div > button {
    background-color: #4CAF50;
    margin-left: 1em;
}

input {
    padding: 0.5em;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 60%;
}
</style>
