<template>
   <div class="relative h-96 w-full flex items-center justify-center">
      <div class="absolute bg-pink-100 rounded-full transform left-1/2 -translate-x-1/2 w-96 h-full">
         <div class="relative text-center space-y-6 flex flex-col items-center">
            <h2 class="text-6xl font-serif text-gray-700 z-50">
               Login
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

               <button @click="login" class="bg-pink-400 text-white px-4 py-2 rounded"> Login
               </button>
            </div>
         </div>
      </div>
   </div>
</template>
<script>
import axios from 'axios'
export default {
   name: 'LoginView',
   data() {
      return {
         username: '',
         password: '',
      }
   },
   methods: {
      async login() {
         let userExists = false;
         let user = null;
         let result = await axios.get(`http://localhost:8080/users`)
         if (result.status == 200 && result.data.length > 0) {
            for (let i = 0; i < result.data.length; i++) {
               if (result.data[i].username === this.username && result.data[i].password === this.password) {
                  user = result.data[i]
                  userExists = true
                  localStorage.setItem('role', user.role)
                  localStorage.setItem('username', user.username)
               }
            }
         } else alert(result.status)
         if (userExists) {
            this.$router.push({ path: '/home' })
         } else alert('user does not exist')
      }
   }
}
</script>