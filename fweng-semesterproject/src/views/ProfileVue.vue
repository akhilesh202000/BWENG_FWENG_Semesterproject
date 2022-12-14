<template>
    <div class="relative h-96 w-full flex items-center justify-center">
        <div class="absolute bg-pink-100 rounded-full transform left-1/2 -translate-x-1/2 w-96 h-full"></div>
        <div class="relative text-center space-y-6 flex flex-col items-center">
            <h2 class="text-6xl font-serif text-gray-700 z-50">
                Profile
            </h2>
            <div class="text-4x1">
                <label for="username"
                    class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">username</label>
                <input type="text" id="username" v-model="username" class="
         bg-gray-50 border border-gray-300 text-gray-900 
         text-sm rouned-lg focus:ring-blue-500 focus:border-blue-500 
         block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 
         dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 
         dark:focus:border-blue-500" placeholder="username" />

                <label for="password"
                    class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">password</label>
                <input type="password" id="password" v-model="password" class="
         bg-gray-50 border border-gray-300 text-gray-900 
         text-sm rouned-lg focus:ring-blue-500 focus:border-blue-500 
         block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 
         dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 
         dark:focus:border-blue-500" placeholder="password" />

                <label for="role" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">role</label>
                <select id="role" v-model="role" class="
         bg-gray-50 border border-gray-300 text-gray-900 
         text-sm rouned-lg focus:ring-blue-500 focus:border-blue-500 
         block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 
         dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 
         dark:focus:border-blue-500">
                    <option disabled value="">Please select one</option>
                    <option>admin</option>
                    <option>user</option>
                    <option>visitor</option>
                </select>
                <button @click="update" class="bg-pink-400 mr-5 mt-5 text-white px-4 py-2 rounded">Update</button>
                <button @click="logout" class="bg-pink-400 text-white px-4 py-2 rounded">LogOut</button>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    name: 'ProfilVue',
    data() {
        return {
            tmp: localStorage.getItem('username'),
            username: '',
            password: '',
            role: ''
        }
    },
    methods: {
        myFunctionOnLoad: async function () {
            let result = await axios.get('http://localhost:8080/users/' + this.tmp)
            console.warn(result.data)
            this.username = result.data.username
            this.password = result.data.password
            this.role = result.data.role
        },
        update: async function () {
            const user = {
                username: this.username,
                password: this.password,
                role: this.role
            };
            await axios.patch('http://localhost:8080/users/' + this.tmp, user)
                .then(function (response) {
                    confirm('User updated succesfully')
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        logout() {
            localStorage.clear()
            confirm('Bye')
            this.$router.push({ path: '/' })
        }
    },
    created: function () {
        this.myFunctionOnLoad()
    }
}
</script>
<style>

</style>