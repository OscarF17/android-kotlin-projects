package flores.oscar.viewbindingcompras

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import flores.oscar.viewbindingcompras.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var taskList:ArrayList<String>
    // private lateinit var buttonAdd: Button
    // private lateinit var buttonDel: Button
    // private lateinit var editTextTask: EditText
    // private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // listView = findViewById(R.id.listViewTools)
        // editTextTask = findViewById(R.id.editTextTask)
        var lastSelect: Int = -1

        taskList = ArrayList()
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,taskList)
        binding.listViewTools.adapter = adapter
        // buttonAdd = findViewById(R.id.buttonAdd)
        // buttonDel = findViewById(R.id.buttonDel)

        binding.buttonAdd.setOnClickListener{
            // Si no hay nada seleccionado, solo agregar
            if(lastSelect == -1) {
                val task = binding.editTextTask.text.toString()
                if(task.isNotEmpty()) {
                    taskList.add(task)
                    adapter.notifyDataSetChanged()
                    binding.editTextTask.text.clear()
                }
                else{
                    Toast.makeText(this,"Introduzca una tarea", Toast.LENGTH_SHORT).show()
                }
            }
            // Si hay algo seleccionado, editar
            else {
                val text = binding.editTextTask.text.toString()
                // Evitar que pongan elementos vacíos
                if(text != null && text != "") {
                    taskList.set(lastSelect, text)
                    adapter.notifyDataSetChanged()
                    binding.editTextTask.text.clear()
                    binding.listViewTools.getChildAt(lastSelect).setBackgroundColor(Color.WHITE)
                    lastSelect = -1
                    updateButtons(lastSelect)
                }
            }
        }

        binding.buttonDel.setOnClickListener {
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
                binding.listViewTools.getChildAt(lastSelect).setBackgroundColor(Color.WHITE)
                lastSelect = -1
                updateButtons(lastSelect)
            }
        }

        binding.listViewTools.setOnItemClickListener{parent,view,position,id ->
            binding.listViewTools.requestFocusFromTouch()

            // Si no hay elemenetos seleccionados
            if(lastSelect == -1) {
                lastSelect = position
                binding.listViewTools.getChildAt(position).setBackgroundColor(Color.YELLOW)
                binding.listViewTools.setSelection(position)
                updateButtons(lastSelect)
            }
            // Si se está clickeando al elemento seleccionado
            else if(position == lastSelect) {
                binding.listViewTools.getChildAt(position).setBackgroundColor(Color.WHITE)
                lastSelect = -1
                updateButtons(lastSelect)
            }
            // Si es otro elemento
            else {
                // Quitarle el color al seleccionado previo
                binding.listViewTools.getChildAt(lastSelect).setBackgroundColor(Color.WHITE)
                binding.listViewTools.setSelection(position)
                binding.listViewTools.getChildAt(position).setBackgroundColor(Color.YELLOW)
                lastSelect = position
                updateButtons(lastSelect)
            }
        }
    }
    fun updateButtons(lastSelect:Int) {
        if(lastSelect != -1) {
            binding.buttonAdd.text = "Editar"
            binding.buttonDel.text = "Borrar"
            binding.editTextTask.setText(binding.listViewTools.getItemAtPosition(lastSelect).toString())
        }
        else {
            binding.buttonAdd.text = "Agregar"
            binding.buttonDel.text = "Borrar último"
            binding.editTextTask.setText("")
        }
    }
}