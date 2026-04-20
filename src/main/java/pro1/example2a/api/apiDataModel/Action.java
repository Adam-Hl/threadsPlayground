package pro1.example2a.api.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Action
{
    @SerializedName("obsazeni")
    public int personsCount;
    @SerializedName("nazev")
    public String title;
    @SerializedName("katedra")
    public String department;
    @SerializedName("ucitIdno")
    public long teacherId;
}
