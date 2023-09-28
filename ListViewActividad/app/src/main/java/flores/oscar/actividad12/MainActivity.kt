package flores.oscar.actividad12

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var taskList:ArrayList<String>
    private lateinit var buttonAdd: Button
    private lateinit var buttonDel: Button
    private lateinit var editTextTask: EditText
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listViewTools)
        editTextTask = findViewById(R.id.editTextTask)
        var lastSelect: Int = -1

        taskList = ArrayList()
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,taskList)
        listView.adapter = adapter
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonDel = findViewById(R.id.buttonDel)

        buttonAdd.setOnClickListener{
            // Si no hay nada seleccionado, solo agregar
            if(lastSelect == -1) {
                val task = editTextTask.text.toString()
                if(task.isNotEmpty()) {
                    taskList.add(task)
                    adapter.notifyDataSetChanged()
                    editTextTask.text.clear()
                }
                else{
                    Toast.makeText(this,"Introduzca una tarea", Toast.LENGTH_SHORT).show()
                }
            }
            // Si hay algo seleccionado, editar
            else {
                val text = editTextTask.text.toString()
                // Evitar que pongan elementos vacíos
                if(text != null && text != "") {
                    taskList.set(lastSelect, text)
                    adapter.notifyDataSetChanged()
                    editTextTask.text.clear()
                    listView.getChildAt(lastSelect).setBackgroundColor(Color.WHITE)
                    lastSelect = -1
                    updateButtons(lastSelect)
                }
            }
        }

        buttonDel.setOnClickListener {
            // Si no hay nada seleccionado, borrar último
            if(lastSelect == -1) {
                // Remover el último elemento de la lista si exsite
                if(taskList.isNotEmpty()) {
                    taskList.removeAt(taskList.size - 1)
                    adapter.notifyDataSetChanged()
                }
                else {
                    Toast.makeText(this,"La lista está vacía", Toast.LENGTH_SHORT).show()
                }
            }
            // Si hay algo seleccionado, borrar ese
            else {
                taskList.removeAt(lastSelect)
                adapter.notifyDataSetChanged()
                listView.getChildAt(lastSelect).setBackgroundColor(Color.WHITE)
                lastSelect = -1
                updateButtons(lastSelect)
            }
        }

        listView.setOnItemClickListener{parent,view,position,id ->
            listView.requestFocusFromTouch()

            // Si no hay elemenetos seleccionados
            if(lastSelect == -1) {
                lastSelect = position
                listView.getChildAt(position).setBackgroundColor(Color.YELLOW)
                listView.setSelection(position)
                updateButtons(lastSelect)
            }
            // Si se está clickeando al elemento seleccionado
            else if(position == lastSelect) {
                listView.getChildAt(position).setBackgroundColor(Color.WHITE)
                lastSelect = -1
                updateButtons(lastSelect)
            }
            // Si es otro elemento
            else {
                // Quitarle el color al seleccionado previo
                listView.getChildAt(lastSelect).setBackgroundColor(Color.WHITE)
                listView.setSelection(position)
                listView.getChildAt(position).setBackgroundColor(Color.YELLOW)
                lastSelect = position
                updateButtons(lastSelect)
            }
        }
    }
    fun updateButtons(lastSelect:Int) {
        if(lastSelect != -1) {
            buttonAdd.text = "Editar"
            buttonDel.text = "Borrar"
            editTextTask.setText(listView.getItemAtPosition(lastSelect).toString())
        }
        else {
            buttonAdd.text = "Agregar"
            buttonDel.text = "Borrar último"
            editTextTask.setText("")
        }
    }
}