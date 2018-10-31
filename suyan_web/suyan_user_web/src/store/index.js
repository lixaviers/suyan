import Vue from 'vue';
import Vuex from 'vuex';
import common from './modules/common';
import user from './modules/user';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    common,
    user
  },
	state: {
		id: 0
	},
	mutations: {
		getId (state, id) {
			state.id = id;
		}
	},
  strict: process.env.NODE_ENV !== 'production'
})

