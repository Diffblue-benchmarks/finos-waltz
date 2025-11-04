package org.finos.waltz.data.orgunit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class OrganisationalUnitIdSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> organisationalUnitIdSelectorFactory.mkForOptions(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions2() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("foo"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> organisationalUnitIdSelectorFactory.mkForOptions(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions3() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    organisationalUnitIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions4() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("foo"));
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> organisationalUnitIdSelectorFactory.mkForOptions(options));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions5() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    organisationalUnitIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions6() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    organisationalUnitIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions7() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("foo"));
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> organisationalUnitIdSelectorFactory.mkForOptions(options));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions8() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("foo"));
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> organisationalUnitIdSelectorFactory.mkForOptions(options));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link OrganisationalUnitIdSelectorFactory}
   */
  @Test
  void testNewOrganisationalUnitIdSelectorFactory() {
    // Arrange and Act
    OrganisationalUnitIdSelectorFactory actualOrganisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);
    actualOrganisationalUnitIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link OrganisationalUnitIdSelectorFactory}
   */
  @Test
  void testNewOrganisationalUnitIdSelectorFactory2() {
    // Arrange and Act
    OrganisationalUnitIdSelectorFactory actualOrganisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference()).thenReturn(entityReference);
    actualOrganisationalUnitIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link OrganisationalUnitIdSelectorFactory}
   */
  @Test
  void testNewOrganisationalUnitIdSelectorFactory3() {
    // Arrange and Act
    OrganisationalUnitIdSelectorFactory actualOrganisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.entityReference()).thenReturn(entityReference);
    actualOrganisationalUnitIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
  }
}
