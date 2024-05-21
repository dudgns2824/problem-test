package dudgns.com.backend.commons.data.entity.problemTest

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "company")
class CompanyEntity {
    @Id
    @Column(name = "company_code")
    var companyCode: Int? = null

    @Column(name = "company_name")
    var companyName: String? = null
}