package org.finos.waltz.data.orgunit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OrganisationalUnitIdSelectorFactoryDiffblueTest {
  /**
   * Test new {@link OrganisationalUnitIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link OrganisationalUnitIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new OrganisationalUnitIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrganisationalUnitIdSelectorFactory.<init>()"})
  void testNewOrganisationalUnitIdSelectorFactory_thenCallsId() {
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
   * Test new {@link OrganisationalUnitIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link OrganisationalUnitIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new OrganisationalUnitIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrganisationalUnitIdSelectorFactory.<init>()"})
  void testNewOrganisationalUnitIdSelectorFactory_thenCallsId2() {
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
   * Test new {@link OrganisationalUnitIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link OrganisationalUnitIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new OrganisationalUnitIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrganisationalUnitIdSelectorFactory.<init>()"})
  void testNewOrganisationalUnitIdSelectorFactory_thenCallsId3() {
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

  /**
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <p>
   * Method under test: {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions() {
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
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code CHILDREN}.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code CHILDREN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given 'CHILDREN'; when IdSelectionOptions scope() return 'CHILDREN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenChildren_whenIdSelectionOptionsScopeReturnChildren() {
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
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code CHILDREN}.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code CHILDREN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given 'CHILDREN'; when IdSelectionOptions scope() return 'CHILDREN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenChildren_whenIdSelectionOptionsScopeReturnChildren2() {
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
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnAll() {
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
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code EXACT}.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code EXACT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given 'EXACT'; when IdSelectionOptions scope() return 'EXACT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenExact_whenIdSelectionOptionsScopeReturnExact() {
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
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code EXACT}.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code EXACT}.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given 'EXACT'; when IdSelectionOptions scope() return 'EXACT'; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenExact_whenIdSelectionOptionsScopeReturnExact_thenCallsId() {
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
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code PARENTS}.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code PARENTS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given 'PARENTS'; when IdSelectionOptions scope() return 'PARENTS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenParents_whenIdSelectionOptionsScopeReturnParents() {
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
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code PARENTS}.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code PARENTS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given 'PARENTS'; when IdSelectionOptions scope() return 'PARENTS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenParents_whenIdSelectionOptionsScopeReturnParents2() {
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
}
