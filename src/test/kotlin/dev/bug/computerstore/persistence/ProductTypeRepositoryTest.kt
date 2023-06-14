package dev.bug.computerstore.persistence

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql

class ProductTypeRepositoryTest: DbTest() {

    @Autowired
    private lateinit var productTypeRepository: ProductTypeRepository

    @ParameterizedTest(name = "{index} - product type `{0}`")
    @ValueSource(strings = ["Настольный компьютер", "HDD", "Ноутбук", "Монитор"])
    @Sql("/scripts/init_three_product_types.sql")
    fun `should return product type if it's exists`(productTypeName: String) {
        val productType = productTypeRepository.findByName(productTypeName)

        assertThat(productType).isNotEmpty
        assertThat(productType).map { it.name }.hasValue(productTypeName)
    }

    @ParameterizedTest(name = "{index} - `{0}`")
    @ValueSource(strings = ["Some type", "Видеокарта"])
    @NullAndEmptySource
    fun `should return empty if product type doesn't exist`(productTypeName: String?) {
        val productType = productTypeRepository.findByName(productTypeName)

        assertThat(productType).isEmpty
    }

    @AfterEach
    fun tearDown() {
        productTypeRepository.deleteAll()
    }
}