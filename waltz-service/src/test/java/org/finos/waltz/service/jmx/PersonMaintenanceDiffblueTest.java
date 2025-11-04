package org.finos.waltz.service.jmx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;

class PersonMaintenanceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PersonMaintenance#PersonMaintenance(PersonHierarchyService)}
   *   <li>{@link PersonMaintenance#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertEquals("Person",
        (new PersonMaintenance(new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99))))
            .getName());
  }
}
