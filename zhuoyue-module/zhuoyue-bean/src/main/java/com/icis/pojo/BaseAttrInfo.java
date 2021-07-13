package com.icis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author LYQ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BaseAttrInfo implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;

    @Transient
    private List<BaseAttrValue> attrValueList;
}
