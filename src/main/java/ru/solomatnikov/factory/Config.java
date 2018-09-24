package ru.solomatnikov.factory;

import ru.solomatnikov.model.Staff.Staff;

import javax.xml.bind.annotation.XmlAnyElement;
import java.util.List;

public class Config <T extends Staff>{


    private List<T> any;

    public List<T> getAny() {
        return any;
    }
    @XmlAnyElement(lax=true)
    public void setAny(List<T> any) {
        this.any = any;
    }
}
