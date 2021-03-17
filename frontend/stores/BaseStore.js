import { observable } from "mobx";

class BaseStore {
  @observable
  loading = false
  @observable
  loaded = null
  @observable
  data = null

  //
  // Api
  //

  loadData = (rest) => {
    this.loading = true
    this.loaded = false
    return rest().then(this.loadDataSuccess).catch(this.loadDataError)
  }


  //
  // Helpers
  //

  @action.bound
  loadDataSuccess(data) {
    this.loading = false
    this.loaded = true
    this.data = data
    return data
  }

  @action.bound
  loadDataError(error) {
    this.loading = false
    this.loaded = true
    this.error = `${error}`
    this.data = null

    //this.notificationStore.notifyError(error) notify about error
    throw error
  }

}