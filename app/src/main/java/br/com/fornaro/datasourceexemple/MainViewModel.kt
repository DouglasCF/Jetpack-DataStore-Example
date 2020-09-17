package br.com.fornaro.datasourceexemple

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val sharedPrefs: SharedPreferences
) : ViewModel() {

    private val _counter = MutableLiveData(sharedPrefs.getInt(COUNTER_VALUE, 0))
    val counter: LiveData<Int> get() = _counter

    fun increment() {
        sharedPrefs.edit {
            val newValue = sharedPrefs.getInt(COUNTER_VALUE, 0) + 1
            putInt(COUNTER_VALUE, newValue)
            _counter.value = newValue
        }
    }

    companion object {
        private const val COUNTER_VALUE = "counter_value"
    }
}