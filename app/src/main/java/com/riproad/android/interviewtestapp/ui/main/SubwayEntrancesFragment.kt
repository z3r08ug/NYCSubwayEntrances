package com.riproad.android.interviewtestapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.riproad.android.interviewtestapp.R
import com.riproad.android.interviewtestapp.model.Filter
import com.riproad.android.interviewtestapp.model.SubwayEntrancesResponse
import com.riproad.android.interviewtestapp.network.RemoteDataSource
import com.riproad.android.interviewtestapp.network.RemoteServiceHelper
import com.riproad.android.interviewtestapp.util.FilterAdapter
import com.riproad.android.interviewtestapp.util.State.*
import com.riproad.android.interviewtestapp.util.SubwayEntranceAdapter
import kotlinx.android.synthetic.main.subway_entrances_fragment.*

class SubwayEntrancesFragment : Fragment() {
    companion object {
        fun newInstance() = SubwayEntrancesFragment()
    }

    private lateinit var viewModel: SubwayEntrancesViewModel
    private val subwayEntrancesMap = HashMap<Char, ArrayList<Int>>()
    private lateinit var entrancesList: List<List<String>>
    private val filters = ArrayList<Filter>()
    private lateinit var filterAdapter: FilterAdapter
    private lateinit var subwayAdapter: SubwayEntranceAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.subway_entrances_fragment, container, false)
        viewModel = ViewModelProvider(this, ViewModelFactory(RemoteServiceHelper(RemoteDataSource.subwayEntrancesService))).get(SubwayEntrancesViewModel::class.java)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSubwayMap()
        setupFilters()
        setupObservers()
        setupUi()
    }

    fun loadFilteredEntrances(char: Char, lastPos: Int) {
        if (lastPos != -1) {
            val filteredEntrances = ArrayList<ArrayList<String>>()
            for (i in subwayEntrancesMap[char]!!.indices) {
                filteredEntrances.add(entrancesList[subwayEntrancesMap[char]?.get(i)!!] as ArrayList<String>)
            }
            subwayAdapter = SubwayEntranceAdapter(filteredEntrances)
        } else {
            subwayAdapter = SubwayEntranceAdapter(entrancesList)
        }
        subwayEntrancesRV.adapter = subwayAdapter
    }

    private fun setupUi() {
        filtersRV.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        filterAdapter = FilterAdapter(filters, this)
        filtersRV.addItemDecoration(
                DividerItemDecoration(
                        filtersRV.context,
                        (filtersRV.layoutManager as LinearLayoutManager).orientation
                )
        )
        filtersRV.adapter = filterAdapter

        subwayEntrancesRV.layoutManager = LinearLayoutManager(activity)
        subwayEntrancesRV.addItemDecoration(
                DividerItemDecoration(
                        subwayEntrancesRV.context,
                        (subwayEntrancesRV.layoutManager as LinearLayoutManager).orientation
                )
        )
    }

    private fun setupSubwayMap() {
        subwayEntrancesMap['1'] = ArrayList()
        subwayEntrancesMap['2'] = ArrayList()
        subwayEntrancesMap['3'] = ArrayList()
        subwayEntrancesMap['4'] = ArrayList()
        subwayEntrancesMap['5'] = ArrayList()
        subwayEntrancesMap['6'] = ArrayList()
        subwayEntrancesMap['7'] = ArrayList()
        subwayEntrancesMap['A'] = ArrayList()
        subwayEntrancesMap['C'] = ArrayList()
        subwayEntrancesMap['E'] = ArrayList()
        subwayEntrancesMap['B'] = ArrayList()
        subwayEntrancesMap['D'] = ArrayList()
        subwayEntrancesMap['F'] = ArrayList()
        subwayEntrancesMap['M'] = ArrayList()
        subwayEntrancesMap['G'] = ArrayList()
        subwayEntrancesMap['L'] = ArrayList()
        subwayEntrancesMap['J'] = ArrayList()
        subwayEntrancesMap['Z'] = ArrayList()
        subwayEntrancesMap['N'] = ArrayList()
        subwayEntrancesMap['Q'] = ArrayList()
        subwayEntrancesMap['R'] = ArrayList()
        subwayEntrancesMap['W'] = ArrayList()
        subwayEntrancesMap['S'] = ArrayList()
        subwayEntrancesMap['V'] = ArrayList()
    }
    
    private fun setupFilters() {

        filters.add(Filter('1'))
        filters.add(Filter('2'))
        filters.add(Filter('3'))
        filters.add(Filter('4'))
        filters.add(Filter('5'))
        filters.add(Filter('6'))
        filters.add(Filter('7'))
        filters.add(Filter('A'))
        filters.add(Filter('C'))
        filters.add(Filter('E'))
        filters.add(Filter('B'))
        filters.add(Filter('D'))
        filters.add(Filter('F'))
        filters.add(Filter('M'))
        filters.add(Filter('G'))
        filters.add(Filter('L'))
        filters.add(Filter('J'))
        filters.add(Filter('Z'))
        filters.add(Filter('N'))
        filters.add(Filter('Q'))
        filters.add(Filter('R'))
        filters.add(Filter('W'))
        filters.add(Filter('S'))
        filters.add(Filter('V'))
    }

    private fun setupObservers() {
        viewModel.getSubwayEntrances().observe(viewLifecycleOwner, {
            it?.let { state ->
                when (state) {
                    is Success -> {
                        subwayEntrancesRV.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        mapEntrances(state.response)
                        subwayAdapter = SubwayEntranceAdapter(state.response.result?.data)
                        subwayEntrancesRV.adapter = subwayAdapter
                    }
                    is Failure -> {
                        subwayEntrancesRV.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        displayErrorMessage(state.error.message)
                    }
                    is Loading -> {
                        progressBar.visibility = View.VISIBLE
                        subwayEntrancesRV.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun mapEntrances(entrances: SubwayEntrancesResponse) {
        entrancesList = entrances.result?.data!!
        for (i in entrancesList.indices) {
            when {
                entrancesList[i][12].contains('1') -> {
                    subwayEntrancesMap['1']?.add(i)
                }
                entrancesList[i][12].contains('2') -> {
                    subwayEntrancesMap['2']?.add(i)
                }
                entrancesList[i][12].contains('3') -> {
                    subwayEntrancesMap['3']?.add(i)
                }
                entrancesList[i][12].contains('4') -> {
                    subwayEntrancesMap['4']?.add(i)
                }
                entrancesList[i][12].contains('5') -> {
                    subwayEntrancesMap['5']?.add(i)
                }
                entrancesList[i][12].contains('6') -> {
                    subwayEntrancesMap['6']?.add(i)
                }
                entrancesList[i][12].contains('7') -> {
                    subwayEntrancesMap['7']?.add(i)
                }
                entrancesList[i][12].contains('A') -> {
                    subwayEntrancesMap['A']?.add(i)
                }
                entrancesList[i][12].contains('B') -> {
                    subwayEntrancesMap['B']?.add(i)
                }
                entrancesList[i][12].contains('C') -> {
                    subwayEntrancesMap['C']?.add(i)
                }
                entrancesList[i][12].contains('D') -> {
                    subwayEntrancesMap['D']?.add(i)
                }
                entrancesList[i][12].contains('E') -> {
                    subwayEntrancesMap['E']?.add(i)
                }
                entrancesList[i][12].contains('F') -> {
                    subwayEntrancesMap['F']?.add(i)
                }
                entrancesList[i][12].contains('G') -> {
                    subwayEntrancesMap['G']?.add(i)
                }
                entrancesList[i][12].contains('J') -> {
                    subwayEntrancesMap['J']?.add(i)
                }
                entrancesList[i][12].contains('L') -> {
                    subwayEntrancesMap['L']?.add(i)
                }
                entrancesList[i][12].contains('M') -> {
                    subwayEntrancesMap['M']?.add(i)
                }
                entrancesList[i][12].contains('N') -> {
                    subwayEntrancesMap['N']?.add(i)
                }
                entrancesList[i][12].contains('Q') -> {
                    subwayEntrancesMap['Q']?.add(i)
                }
                entrancesList[i][12].contains('R') -> {
                    subwayEntrancesMap['R']?.add(i)
                }
                entrancesList[i][12].contains('S') -> {
                    subwayEntrancesMap['S']?.add(i)
                }
                entrancesList[i][12].contains('T') -> {
                    subwayEntrancesMap['T']?.add(i)
                }
                entrancesList[i][12].contains('W') -> {
                    subwayEntrancesMap['W']?.add(i)
                }
                entrancesList[i][12].contains('Z') -> {
                    subwayEntrancesMap['Z']?.add(i)
                }
            }
        }
    }

    private fun displayErrorMessage(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}