package com.example.recipekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recipekeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnAddRecipe.setOnClickListener{
            val inputRecipe = binding.edtRecipeName.text.toString()
            if (inputRecipe.isNotBlank()) {
                binding.edtRecipeArea.append("Recipe Name: $inputRecipe\n\n")
            } else {
                Toast.makeText(this, "Please add Recipe Name", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnAddIngredients.setOnClickListener{
            val inputIngredients = binding.edtIngredients.text.toString()
            if (inputIngredients.isNotBlank()) {
                binding.edtRecipeArea.append("List of Ingredients:\n " +
                                             "$inputIngredients\n\n")
            } else {
                Toast.makeText(this, "Please add Ingredients", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnAddInstructions.setOnClickListener{
            val inputInstructions = binding.edtInstructions.text.toString()
            if (inputInstructions.isNotBlank()) {
                binding.edtRecipeArea.append("List of Ingredients:\n " +
                        "$inputInstructions\n\n")
            } else {
                Toast.makeText(this, "Please add Instructions", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnSaveRecipe.setOnClickListener {
            if (validateInputs()) {
                Toast.makeText(this, "Recipe Saved", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please complete all Required Information", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnClear.setOnClickListener {
            clearInputs()
        }
    }

    private fun validateInputs(): Boolean {
        return binding.edtRecipeName.text.isNotBlank() &&
                binding.edtIngredients.text.isNotBlank() &&
                binding.edtInstructions.text.isNotBlank() &&
                binding.edtRecipeArea.text.isNotBlank()
    }

    private fun clearInputs() {
        binding.edtRecipeName.text.clear()
        binding.edtIngredients.text.clear()
        binding.edtInstructions.text.clear()
        binding.edtRecipeArea.text.clear()
    }
}