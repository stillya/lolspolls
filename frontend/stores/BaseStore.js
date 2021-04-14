import { action, observable } from "mobx";

class BaseStore {
  @observable 
  loading = true
  @observable
  loaded = false
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

  @action
  loadDataSuccess(data) {
    console.log(data)
    this.loading = false
    this.loaded = true
    this.data = data
    console.log("new" + this.loaded)
    return data
  }

  @action
  loadDataError(error) {
    console.log("new")
    this.loading = false
    this.loaded = true
    this.error = `${error}`
    this.data = null


    //this.notificationStore.notifyError(error) notify about error
    throw error
  }

}

export default BaseStore