package net.codestory2;

import org.codehaus.jackson.annotate.JsonProperty;

public class Geek
{
    @JsonProperty("NOM")
    private String nom;
    @JsonProperty("PRENOM")
    private String prenom;
    @JsonProperty("EMAIL")
    private String email;
    @JsonProperty("VILLE")
    private String ville;
    @JsonProperty("LIKE1")
    private String like1;
    @JsonProperty("LIKE2")
    private String like2;
    @JsonProperty("LIKE3")
    private String like3;
    @JsonProperty("HATE1")
    private String hate1;
    @JsonProperty("HATE2")
    private String hate2;

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVill(String ville)
    {
        this.ville = ville;
    }

    public String getLike1()
    {
        return like1;
    }

    public void setLike1(String like1)
    {
        this.like1 = like1;
    }

    public String getLike2()
    {
        return like2;
    }

    public void setLike2(String like2)
    {
        this.like2 = like2;
    }

    public String getLike3()
    {
        return like3;
    }

    public void setLike3(String like3)
    {
        this.like3 = like3;
    }

    public String getHate1()
    {
        return hate1;
    }

    public void setHate1(String hate1)
    {
        this.hate1 = hate1;
    }

    public String getHate2()
    {
        return hate2;
    }

    public void setHate2(String hate2)
    {
        this.hate2 = hate2;
    }

    @Override
    public String toString()
    {
        return "Geek [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", ville=" + ville + ", like1=" + like1 + ", like2=" + like2 + ", like3=" + like3 + ", hate1="
                + hate1 + ", hate2=" + hate2 + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((hate1 == null) ? 0 : hate1.hashCode());
        result = prime * result + ((hate2 == null) ? 0 : hate2.hashCode());
        result = prime * result + ((like1 == null) ? 0 : like1.hashCode());
        result = prime * result + ((like2 == null) ? 0 : like2.hashCode());
        result = prime * result + ((like3 == null) ? 0 : like3.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
        result = prime * result + ((ville == null) ? 0 : ville.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Geek other = (Geek) obj;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (hate1 == null)
        {
            if (other.hate1 != null)
                return false;
        }
        else if (!hate1.equals(other.hate1))
            return false;
        if (hate2 == null)
        {
            if (other.hate2 != null)
                return false;
        }
        else if (!hate2.equals(other.hate2))
            return false;
        if (like1 == null)
        {
            if (other.like1 != null)
                return false;
        }
        else if (!like1.equals(other.like1))
            return false;
        if (like2 == null)
        {
            if (other.like2 != null)
                return false;
        }
        else if (!like2.equals(other.like2))
            return false;
        if (like3 == null)
        {
            if (other.like3 != null)
                return false;
        }
        else if (!like3.equals(other.like3))
            return false;
        if (nom == null)
        {
            if (other.nom != null)
                return false;
        }
        else if (!nom.equals(other.nom))
            return false;
        if (prenom == null)
        {
            if (other.prenom != null)
                return false;
        }
        else if (!prenom.equals(other.prenom))
            return false;
        if (ville == null)
        {
            if (other.ville != null)
                return false;
        }
        else if (!ville.equals(other.ville))
            return false;
        return true;
    }

}
