package ma.ensa.inscription.beans;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Filiere implements Parcelable {
    private Long id;
    private String code;
    private String libelle;

    public Filiere(Long id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }

    protected Filiere(Parcel in) {
        id = in.readLong();
        code = in.readString();
        libelle = in.readString();
    }

    public static final Creator<Filiere> CREATOR = new Creator<Filiere>() {
        @Override
        public Filiere createFromParcel(Parcel in) {
            return new Filiere(in);
        }

        @Override
        public Filiere[] newArray(int size) {
            return new Filiere[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(code);
        dest.writeString(libelle);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

