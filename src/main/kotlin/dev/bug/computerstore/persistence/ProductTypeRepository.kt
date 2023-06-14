package dev.bug.computerstore.persistence

import dev.bug.computerstore.persistence.entities.ProductType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ProductTypeRepository: CrudRepository<ProductType, Long> {

    fun findByName(name: String?): Optional<ProductType>
}