package dev.bug.computerstore.persistence.entities

import jakarta.persistence.*
import jakarta.persistence.CascadeType.*

@Entity
@Table(name = "product_type")
data class ProductType(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productTypeId: Long?,

    @Column(name = "name", length = 256, nullable = false, unique = true)
    val name: String,

    @ManyToMany(cascade = [ALL])
    @JoinTable(
        name = "rg_product_type_form_factor",
        joinColumns = [JoinColumn(name = "product_type_id")],
        inverseJoinColumns = [JoinColumn(name = "form_factor_id")]
    )
    val formFactors: Set<FormFactor> = mutableSetOf()
)
