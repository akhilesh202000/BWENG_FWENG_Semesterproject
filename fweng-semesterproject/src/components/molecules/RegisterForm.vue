<template lang="">
   <div class="flex flex-column w-full justify-center">
      <form action="" method="" class="p-10">
         <!-- <BaseInput name="firstname" label="First Name"/>
         <BaseInput name="lastname" label="Last Name"/>
         <BaseInput name="username" label="Username"/>
         <BaseInput
            name="email"
            type="email"
            v-model="form.values.email"
            @blur="validate('email')"
            label="Email"/>
         <p v-if="!!form.errors.email" class="text-red-600">
            {{ form.errors.email }}
         </p>
         <BaseInput name="password" type="password" label="Password"/>
         <BaseInput name="repeatPassword" type="password" label="Repeat Password"/> 
         <BaseButton name="submit" id="submit" type="submit" value="submit" text="Submit"/> -->

         <div>
            <label for="firstname">First Name</label>
            <br>
            <input
               type="text"
               id="firstname"
               v-model="form.values.firstname"
               @blur="validate('firstname')"
            />
         </div>
         <p v-if="!!form.errors.firstname" class="text-red-600">
         {{ form.errors.firstname }}
         </p>

         <div>
            <label for="lastname">Last Name</label>
            <br>
            <input
               type="text"
               id="lastname"
               v-model="form.values.lastname"
               @blur="validate('lastname')"
            />
         </div>
         <p v-if="!!form.errors.lastname" class="text-red-600">
         {{ form.errors.firstname }}
         </p>

         <div>
            <label for="username">Userame</label>
            <br>
            <input
               type="text"
               id="username"
               v-model="form.values.username"
               @blur="validate('username')"
            />
         </div>
         <p v-if="!!form.errors.username" class="text-red-600">
         {{ form.errors.firstname }}
         </p>

         <div>
            <label for="email">Email</label>
            <br>
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
            <br>
            <input
               type="password"
               id="password" 
               v-model="form.values.password"
               @blur="validate('password')">
         </div>
         <p v-if="!!form.errors.password" class="text-red-600">
         {{ form.errors.password }}
         </p>

         <input type="submit" @click="register()" value="Submit">

      </form>
   </div>
</template>
<script>
// import BaseInput from '@/components/atoms/BaseInput.vue'
// import BaseButton from '@/components/atoms/BaseButton.vue'
import { object, string, ref} from 'yup';

const requiredErrorString = "Please enter the required field";
const alphabetErrorString = "Only letters are allowed for this field";

const registerFormSchema = object().shape({
   firstname: string().matches(/^[aA-zZ\s]+$/, alphabetErrorString).required(requiredErrorString),
   lastname: string().matches(/^[aA-zZ\s]+$/, alphabetErrorString).required(requiredErrorString),
   username: string().required(requiredErrorString),
   email: string().email().required(),
   password: string().min(8).required(),
   repeatPassword: string().oneOf([ref('password'), null], 'Passwords must match')
});

export default {
   name: 'RegisterForm',
   components: {
//      BaseInput, BaseButton,
   },
   data: () => ({
      form: {
         values: { firstname: '', lastname:'', username:'', email: '', password: '', repeatPassword: '' },
         errors: { firstname: '', lastname:'', username:'', email: '', password: '', repeatPassword: '' },
      },
   }),
   methods:{
      register() {
         registerFormSchema
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
      registerFormSchema
         .validateAt(field, this.form.values, { 
            abortEarly: false
         })
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