## Recycler View

### Data Class:
```kotlin
// The class in which the properties of the object are held.
class Languages(
    val language : String,
    val year : Int,
    val logo : Int) : Serializable {
    }
```
### and Singleton Class:
```kotlin
// Singleton : A class that contains a single object.
object Singleton {
    var chosenLanguage : Languages? = null
}
```
### Recycle View Adapter Class:
```kotlin
class RecycleViewAdapter(private val languageList : ArrayList<Languages>) : RecyclerView.Adapter<RecycleViewAdapter.LanguageHolder>() {

    // The holder object of the corresponding view.
    class LanguageHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) { }

    // When the view holder is created, bind the layout's views.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LanguageHolder(binding)
    }

    // After bind, transfer the data to view...
    override fun onBindViewHolder(holder: LanguageHolder, position: Int) {
        holder.binding.textViewRecycleItem.text = languageList[position].language

        // When the item is clicked, go to the detail activity of the relevant object.
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)

            // Send data with Intent.
            //intent.putExtra("language", languageList[position])

            // Send data with Singleton.
            Singleton.chosenLanguage = languageList[position]

            holder.itemView.context.startActivity(intent)
        }
    }

    // Get the size of the recyclerview to be created.
    override fun getItemCount(): Int {
        return languageList.size
    }
}
```

### MainActivty:
```kotlin
class MainActivity : AppCompatActivity() {

    // Definition View Binding.
    private lateinit var binding: ActivityMainBinding

    // Definition ArrayList Languages.
    private lateinit var languagesList : ArrayList<Languages>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize ArrayList Languages.
        languagesList = ArrayList<Languages>()

        // Create the language objects.
        val kotlin = Languages("Kotlin",2011,R.drawable.kotlin)
        val swift = Languages("Swift",2014,R.drawable.swift)
        val rust = Languages("Rust",2012,R.drawable.rust)
        val go = Languages("Go",2009,R.drawable.go)

        // Add the created objects to the list.
        languagesList.add(kotlin)
        languagesList.add(swift)
        languagesList.add(rust)
        languagesList.add(go)

        // Show items vertically.
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // Create the adapter object.
        val languageAdapter = RecycleViewAdapter(languagesList)
        // Bind the view and adapter.
        binding.recyclerView.adapter = languageAdapter
    }
}
```

### DetailsActivity:
```kotlin
class DetailsActivity : AppCompatActivity() {

    // Definition View Binding.
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding.
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /* Read the incoming data with Intent.
        val intent = intent
        val selectedLanguage = intent.getSerializableExtra("language") as Languages
        binding.textViewLanguage.text = selectedLanguage.language
        binding.textViewYear.text = selectedLanguage.year.toString()
        binding.imageView.setImageResource(selectedLanguage.logo) */

        // Read the incoming data with Singleton.
        val selectedLanguage = Singleton.chosenLanguage
        selectedLanguage?.let {
            binding.textViewLanguage.text = it.language
            binding.textViewYear.text = it.year.toString()
            binding.imageView.setImageResource(it.logo)
        }
    }
}
```
