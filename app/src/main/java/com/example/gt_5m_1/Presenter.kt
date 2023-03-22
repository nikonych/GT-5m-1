package com.example.gt_5m_1

class Presenter {
    val model = Injector.fillCounterModel()
    lateinit var view: CounterView

    fun incrementCount(){
        model.increment()
        view.updateText(model.count.toString())
        isTen()
        isFifteen()
    }

    fun decrementCount(){
        model.decrement()
        view.updateText(model.count.toString())
        isTen()
        isFifteen()
    }

    private fun isTen(){
        if (model.count == 10){
            view.showToast()
        }
    }

    private fun isFifteen(){
        if (model.count == 15){
            view.changeColor()
        } else {
            view.setDefaultColor()
        }
    }

    fun attachView(view: CounterView){
        this.view = view
    }
}