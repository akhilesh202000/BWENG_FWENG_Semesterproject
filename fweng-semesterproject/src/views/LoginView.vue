<template lang="">
   <div>
      <h1>Login</h1>
      <form>
         <div>
            <label for="email">Email</label>
            <input
               type="email"
               id="email"
               v-model="form.values.email"
               @blur="validate('email')"
            />
         </div>
         <p v-if="!!form.errors.email" class="text-red-600">
         {{ form.errors.email }}
         </p>
         <div>
            <label for="password">Password</label>
            <input
               type="password"
               id="password" 
               v-model="form.values.password"
               @blur="validate('password')">
         </div>
         <p v-if="!!form.errors.password" class="text-red-600">
         {{ form.errors.password }}
         </p>
         <input type="submit" @click="login()" value="Submit">
      </form>
   </div>
</template>
<script>
import { object, string } from 'yup';
//import BaseInput from '@/components/atoms/BaseInput.vue';

const loginFormSchema = object().shape({
   email: string().email().required(),
   password: string().min(8).required(),
});

export default {
   name: 'LoginView',
   //components: { BaseInput },
   data: () => ({
      form: {
         values: { email: '', password: '' },
         errors: { email: '', password: '' },
      },
   }),
   methods:{
      login() {
         loginFormSchema
            .validate(this.form.values, { 
               abortEarly: false,
            })
            .then(() => {
               this.form.errors = {
                  email: '',
                  password: '',
               };
            })
            .catch((err) => {
               err.inner.forEach((error) => {
                  this.form.errors[error.path] = error.message;
               });
            });
      },
   },
   validate(field) {
      loginFormSchema
         .validateAt(field, this.form.values)
         .then(() => {
            this.form.errors[field] = '';
         })
         .catch((error) => {
            this.form.errors[field] = error.message;
         });
   }
}
</script>
<style lang="">
   
</style>