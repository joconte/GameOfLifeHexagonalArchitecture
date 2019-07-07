package fr.epsi.jconte.infra;

import java.util.List;

public class RootObject
{
    public List<List<Boolean>> array;
    public String id;

    public List<List<Boolean>> getArray() {
        return array;
    }

    public void setArray(List<List<Boolean>> array) {
        this.array = array;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
