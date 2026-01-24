package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReferenceBuilderContextDiffblueTest {
  @Mock private Map<String, ContextVariableReference> map;

  @InjectMocks private ReferenceBuilderContext referenceBuilderContext;

  /**
   * Test {@link ReferenceBuilderContext#get(String)}.
   *
   * <p>Method under test: {@link ReferenceBuilderContext#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ReferenceBuilderContext.get(String)"})
  void testGet() {
    // Arrange, Act and Assert
    assertNull(new ReferenceBuilderContext().get("Name"));
  }

  /**
   * Test {@link ReferenceBuilderContext#set(String, Object)}.
   *
   * <p>Method under test: {@link ReferenceBuilderContext#set(String, Object)}
   */
  @Test
  @DisplayName("Test set(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReferenceBuilderContext.set(String, Object)"})
  void testSet() {
    // Arrange
    ReferenceBuilderContext referenceBuilderContext = new ReferenceBuilderContext();

    // Act
    referenceBuilderContext.set("Name", null);

    // Assert
    Set<String> keysResult = referenceBuilderContext.keys();
    assertEquals(1, keysResult.size());
    assertTrue(keysResult.contains("Name"));
  }

  /**
   * Test {@link ReferenceBuilderContext#keys()}.
   *
   * <p>Method under test: {@link ReferenceBuilderContext#keys()}
   */
  @Test
  @DisplayName("Test keys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReferenceBuilderContext.keys()"})
  void testKeys() {
    // Arrange, Act and Assert
    assertTrue(new ReferenceBuilderContext().keys().isEmpty());
  }

  /**
   * Test {@link ReferenceBuilderContext#has(String)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#containsKey(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceBuilderContext#has(String)}
   */
  @Test
  @DisplayName("Test has(String); given Map containsKey(Object) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceBuilderContext.has(String)"})
  void testHas_givenMapContainsKeyReturnTrue_thenReturnTrue() {
    // Arrange
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualHasResult = referenceBuilderContext.has("Name");

    // Assert
    verify(map).containsKey(isA(Object.class));
    assertTrue(actualHasResult);
  }

  /**
   * Test {@link ReferenceBuilderContext#has(String)}.
   *
   * <ul>
   *   <li>Given {@link ReferenceBuilderContext} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceBuilderContext#has(String)}
   */
  @Test
  @DisplayName(
      "Test has(String); given ReferenceBuilderContext (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReferenceBuilderContext.has(String)"})
  void testHas_givenReferenceBuilderContext_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ReferenceBuilderContext().has("Name"));
  }

  /**
   * Test {@link ReferenceBuilderContext#declarations()}.
   *
   * <ul>
   *   <li>Given {@link ReferenceBuilderContext} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceBuilderContext#declarations()}
   */
  @Test
  @DisplayName(
      "Test declarations(); given ReferenceBuilderContext (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReferenceBuilderContext.declarations()"})
  void testDeclarations_givenReferenceBuilderContext_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new ReferenceBuilderContext().declarations().isEmpty());
  }

  /**
   * Test {@link ReferenceBuilderContext#declarations()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceBuilderContext#declarations()}
   */
  @Test
  @DisplayName("Test declarations(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReferenceBuilderContext.declarations()"})
  void testDeclarations_thenReturnSizeIsOne() {
    // Arrange
    HashSet<Entry<String, ContextVariableReference>> entrySet = new HashSet<>();
    ImmutableContextVariableReference immutableContextVariableReference =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();
    SimpleEntry<String, ContextVariableReference> simpleEntry =
        new SimpleEntry<>("foo", immutableContextVariableReference);
    entrySet.add(simpleEntry);
    when(map.entrySet()).thenReturn(entrySet);

    // Act
    Set<ContextVariableDeclaration> actualDeclarationsResult =
        referenceBuilderContext.declarations();

    // Assert
    verify(map).entrySet();
    assertEquals(1, actualDeclarationsResult.size());
  }

  /**
   * Test {@link ReferenceBuilderContext#declarations()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceBuilderContext#declarations()}
   */
  @Test
  @DisplayName("Test declarations(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReferenceBuilderContext.declarations()"})
  void testDeclarations_thenReturnSizeIsTwo() {
    // Arrange
    HashSet<Entry<String, ContextVariableReference>> entrySet = new HashSet<>();
    ImmutableContextVariableReference immutableContextVariableReference =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();
    SimpleEntry<String, ContextVariableReference> simpleEntry =
        new SimpleEntry<>("name", immutableContextVariableReference);
    entrySet.add(simpleEntry);
    ImmutableContextVariableReference immutableContextVariableReference2 =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();
    SimpleEntry<String, ContextVariableReference> simpleEntry2 =
        new SimpleEntry<>("foo", immutableContextVariableReference2);
    entrySet.add(simpleEntry2);
    when(map.entrySet()).thenReturn(entrySet);

    // Act
    Set<ContextVariableDeclaration> actualDeclarationsResult =
        referenceBuilderContext.declarations();

    // Assert
    verify(map).entrySet();
    assertEquals(2, actualDeclarationsResult.size());
  }
}
