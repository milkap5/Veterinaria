import java.util.Comparator;

public class AnimalComparatorPorNombre implements Comparator<Animal> {

    @Override
    public int compare(Animal animal1, Animal animal2) {
        // Compara alfabéticamente por el nombre del animal
        return animal1.getNombre().compareTo(animal2.getNombre());
    }
}
