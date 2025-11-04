package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.jooq.InsertQuery;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.TableImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityAliasPopulatorDiffblueTest {
  /**
   * Method under test:
   * {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  void testFetchEntityIdLookupMap() {
    // Arrange
    EntityAliasPopulator entityAliasPopulator = new EntityAliasPopulator(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.ALL, new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  void testFetchEntityIdLookupMap2() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertQuery(Mockito.<Table<Record>>any())).thenReturn(mock(InsertQuery.class));
    dsl.insertQuery(new TableImpl<>("entityKind cannot be null"));
    EntityAliasPopulator entityAliasPopulator = new EntityAliasPopulator(dsl);

    HashSet<String> identifiers = new HashSet<>();
    identifiers.add("entityKind cannot be null");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.ALL, identifiers));
    verify(dsl).insertQuery(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  void testFetchEntityIdLookupMap3() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertQuery(Mockito.<Table<Record>>any())).thenReturn(mock(InsertQuery.class));
    dsl.insertQuery(new TableImpl<>("entityKind cannot be null"));
    EntityAliasPopulator entityAliasPopulator = new EntityAliasPopulator(dsl);

    HashSet<String> identifiers = new HashSet<>();
    identifiers.add("Cannot find lookup map for id for entity kind: %s");
    identifiers.add("entityKind cannot be null");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.ALL, identifiers));
    verify(dsl).insertQuery(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}
   */
  @Test
  void testFetchEntityReferenceLookupMap() {
    // Arrange
    EntityAliasPopulator entityAliasPopulator = new EntityAliasPopulator(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind.ALL, new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}
   */
  @Test
  void testFetchEntityReferenceLookupMap2() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertQuery(Mockito.<Table<Record>>any())).thenReturn(mock(InsertQuery.class));
    dsl.insertQuery(new TableImpl<>("entityKind cannot be null"));
    EntityAliasPopulator entityAliasPopulator = new EntityAliasPopulator(dsl);

    HashSet<String> identifiers = new HashSet<>();
    identifiers.add("entityKind cannot be null");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind.ALL, identifiers));
    verify(dsl).insertQuery(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}
   */
  @Test
  void testFetchEntityReferenceLookupMap3() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertQuery(Mockito.<Table<Record>>any())).thenReturn(mock(InsertQuery.class));
    dsl.insertQuery(new TableImpl<>("entityKind cannot be null"));
    EntityAliasPopulator entityAliasPopulator = new EntityAliasPopulator(dsl);

    HashSet<String> identifiers = new HashSet<>();
    identifiers.add("Cannot find lookup map for entity reference for entity kind: %s");
    identifiers.add("entityKind cannot be null");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind.ALL, identifiers));
    verify(dsl).insertQuery(isA(Table.class));
  }
}
