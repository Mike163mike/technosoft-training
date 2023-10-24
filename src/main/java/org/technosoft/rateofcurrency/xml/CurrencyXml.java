package org.technosoft.rateofcurrency.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Optional;

@XmlRootElement(name = "ValCurse")
public final class CurrencyXml {

    private String date;
    private List<CurrencyDetailsXml> valutes;

    public CurrencyXml() {
    }

    @XmlAttribute(name = "Date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement(name = "Valute")
    public List<CurrencyDetailsXml> getValutes() {
        return valutes;
    }

    public void setValutes(List<CurrencyDetailsXml> valutes) {
        this.valutes = valutes;
    }

    public Optional<CurrencyDetailsXml> findByCode(Integer code) {
        return Optional.ofNullable(valutes.get(code));
    }
}

