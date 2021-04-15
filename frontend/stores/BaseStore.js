import { action, makeAutoObservable, makeObservable, observable } from "mobx";

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
    rest().then(data => this.loadDataSuccess(data)).catch(this.loadDataError)

  }


  //
  // Helpers
  //

  @action.bound
  loadDataSuccess(data) {

    console.log(data)
    this.loading = false
    this.loaded = true
    this.data = data
    console.log("new" + this.loaded)
    return data
  }

  @action.bound
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