package uk.ac.tees.w9601166.careercatalyst.ui.screens.jobs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uk.ac.tees.w9601166.careercatalyst.ui.data.model.Job
import uk.ac.tees.w9601166.careercatalyst.ui.data.model.Results
import uk.ac.tees.w9601166.careercatalyst.ui.data.repository.JobsApi
import uk.ac.tees.w9601166.careercatalyst.ui.data.repository.JobsApiStatus

class JobsViewModel : ViewModel() {
     val _status = MutableLiveData<JobsApiStatus>()
    val status: LiveData<JobsApiStatus>
        get() = _status

     val _properties = MutableLiveData<List<Job>>()
     val _jobs = MutableLiveData<Results>()
     val _jobss = MutableLiveData<List<Job>>()
    val properties: LiveData<List<Job>>
        get() = _properties

    init{ fetchJobs()
    }


     fun fetchJobs(){
        viewModelScope.launch {
            _status.value = JobsApiStatus.LOADING
            try {
                _jobs.value = JobsApi.retrofitService.getJobs()
                _jobss.value = _jobs.value!!.results
                _status.value = JobsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = JobsApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }
}




