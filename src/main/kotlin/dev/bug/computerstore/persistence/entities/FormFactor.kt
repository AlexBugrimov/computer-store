package dev.bug.computerstore.persistence.entities

import jakarta.persistence.*

@Entity
@Table(name = "form_factor")
data class FormFactor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var formFactorId: Long?,

    @Column(name = "name", length = 256, nullable = false, unique = true)
    var name: String,

    @ManyToMany(mappedBy = "formFactors")
    val productTypes: Set<ProductType> = mutableSetOf()
)
