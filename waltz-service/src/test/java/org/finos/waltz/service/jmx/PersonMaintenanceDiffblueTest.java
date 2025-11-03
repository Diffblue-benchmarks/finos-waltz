package org.finos.waltz.service.jmx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PersonMaintenanceDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersonMaintenance#PersonMaintenance(PersonHierarchyService)}
   *   <li>{@link PersonMaintenance#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PersonMaintenance.<init>(PersonHierarchyService)",
      "java.lang.String PersonMaintenance.getName()"})
  void testGettersAndSetters() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertEquals("Person",
        (new PersonMaintenance(new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99))))
            .getName());
  }
}
