package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelKindStat.Builder;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelKindStat.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelKindStatDiffblueTest {
  /**
   * Test Builder {@link Builder#from(LegalEntityRelKindStat)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build relKindId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelKindStat)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelKindStat); given three; then builder build relKindId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelKindStat)"})
  void testBuilderFrom_givenThree_thenBuilderBuildRelKindIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();
    LegalEntityRelKindStat instance = mock(LegalEntityRelKindStat.class);
    when(instance.legalEntityCount()).thenReturn(3);
    when(instance.relationshipCount()).thenReturn(3);
    when(instance.targetEntityCount()).thenReturn(3);
    when(instance.relKindId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).legalEntityCount();
    verify(instance).relKindId();
    verify(instance).relationshipCount();
    verify(instance).targetEntityCount();
    ImmutableLegalEntityRelKindStat buildResult = builderResult.build();
    assertEquals(1L, buildResult.relKindId());
    assertEquals(3, buildResult.legalEntityCount());
    assertEquals(3, buildResult.relationshipCount());
    assertEquals(3, buildResult.targetEntityCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#legalEntityCount(int)}.
   * <p>
   * Method under test: {@link Builder#legalEntityCount(int)}
   */
  @Test
  @DisplayName("Test Builder legalEntityCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.legalEntityCount(int)"})
  void testBuilderLegalEntityCount() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.legalEntityCount(3));
  }

  /**
   * Test Builder {@link Builder#relKindId(long)}.
   * <p>
   * Method under test: {@link Builder#relKindId(long)}
   */
  @Test
  @DisplayName("Test Builder relKindId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relKindId(long)"})
  void testBuilderRelKindId() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relKindId(1L));
  }

  /**
   * Test Builder {@link Builder#relationshipCount(int)}.
   * <p>
   * Method under test: {@link Builder#relationshipCount(int)}
   */
  @Test
  @DisplayName("Test Builder relationshipCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relationshipCount(int)"})
  void testBuilderRelationshipCount() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipCount(3));
  }

  /**
   * Test Builder {@link Builder#targetEntityCount(int)}.
   * <p>
   * Method under test: {@link Builder#targetEntityCount(int)}
   */
  @Test
  @DisplayName("Test Builder targetEntityCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetEntityCount(int)"})
  void testBuilderTargetEntityCount() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityCount(3));
  }

  /**
   * Test Json {@link Json#legalEntityCount()}.
   * <p>
   * Method under test: {@link Json#legalEntityCount()}
   */
  @Test
  @DisplayName("Test Json legalEntityCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.legalEntityCount()"})
  void testJsonLegalEntityCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).legalEntityCount());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertEquals(0, actualJson.legalEntityCount);
    assertEquals(0, actualJson.relationshipCount);
    assertEquals(0, actualJson.targetEntityCount);
    assertEquals(0L, actualJson.relKindId);
    assertFalse(actualJson.legalEntityCountIsSet);
    assertFalse(actualJson.relKindIdIsSet);
    assertFalse(actualJson.relationshipCountIsSet);
    assertFalse(actualJson.targetEntityCountIsSet);
  }

  /**
   * Test Json {@link Json#relKindId()}.
   * <p>
   * Method under test: {@link Json#relKindId()}
   */
  @Test
  @DisplayName("Test Json relKindId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.relKindId()"})
  void testJsonRelKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relKindId());
  }

  /**
   * Test Json {@link Json#relationshipCount()}.
   * <p>
   * Method under test: {@link Json#relationshipCount()}
   */
  @Test
  @DisplayName("Test Json relationshipCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.relationshipCount()"})
  void testJsonRelationshipCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relationshipCount());
  }

  /**
   * Test Json {@link Json#setLegalEntityCount(int)}.
   * <p>
   * Method under test: {@link Json#setLegalEntityCount(int)}
   */
  @Test
  @DisplayName("Test Json setLegalEntityCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setLegalEntityCount(int)"})
  void testJsonSetLegalEntityCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLegalEntityCount(3);

    // Assert
    assertEquals(3, json.legalEntityCount);
    assertTrue(json.legalEntityCountIsSet);
  }

  /**
   * Test Json {@link Json#setRelKindId(long)}.
   * <p>
   * Method under test: {@link Json#setRelKindId(long)}
   */
  @Test
  @DisplayName("Test Json setRelKindId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRelKindId(long)"})
  void testJsonSetRelKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRelKindId(1L);

    // Assert
    assertEquals(1L, json.relKindId);
    assertTrue(json.relKindIdIsSet);
  }

  /**
   * Test Json {@link Json#setRelationshipCount(int)}.
   * <p>
   * Method under test: {@link Json#setRelationshipCount(int)}
   */
  @Test
  @DisplayName("Test Json setRelationshipCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRelationshipCount(int)"})
  void testJsonSetRelationshipCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRelationshipCount(3);

    // Assert
    assertEquals(3, json.relationshipCount);
    assertTrue(json.relationshipCountIsSet);
  }

  /**
   * Test Json {@link Json#setTargetEntityCount(int)}.
   * <p>
   * Method under test: {@link Json#setTargetEntityCount(int)}
   */
  @Test
  @DisplayName("Test Json setTargetEntityCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setTargetEntityCount(int)"})
  void testJsonSetTargetEntityCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTargetEntityCount(3);

    // Assert
    assertEquals(3, json.targetEntityCount);
    assertTrue(json.targetEntityCountIsSet);
  }

  /**
   * Test Json {@link Json#targetEntityCount()}.
   * <p>
   * Method under test: {@link Json#targetEntityCount()}
   */
  @Test
  @DisplayName("Test Json targetEntityCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.targetEntityCount()"})
  void testJsonTargetEntityCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetEntityCount());
  }
}
