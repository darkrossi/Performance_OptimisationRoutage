/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simufiles;

/**
 *
 * @author Mickaël
 */
public class Requete {

    private int m_type;
    private int m_num_file;

    public Requete(int m_type, int m_num_file) {
        this.m_type = m_type;
        this.m_num_file = m_num_file;
    }

    /**
     * @return the m_type
     */
    public int getM_type() {
        return m_type;
    }

    /**
     * @return the m_num_file
     */
    public int getM_num_file() {
        return m_num_file;
    }

    /**
     * @param m_num_file the m_num_file to set
     */
    public void setM_num_file(int m_num_file) {
        this.m_num_file = m_num_file;
    }

    /**
     * @param m_type the m_type to set
     */
    public void setM_type(int m_type) {
        this.m_type = m_type;
    }

}
