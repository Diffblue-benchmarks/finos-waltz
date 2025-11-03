package org.finos.waltz.model.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.WaltzEntity;
import org.finos.waltz.model.external_identifier.ImmutableExternalIdentifier.Builder;
import org.finos.waltz.model.external_identifier.ImmutableExternalIdentifier.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableExternalIdentifierDiffblueTest {
  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   * <p>
   * Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdentifier)} with {@code ExternalIdentifier}.
   * <ul>
   *   <li>Then builder build externalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdentifier)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdentifier) with 'ExternalIdentifier'; then builder build externalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdentifier)"})
  void testBuilderFromWithExternalIdentifier_thenBuilderBuildExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ExternalIdentifier instance = mock(ExternalIdentifier.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.system()).thenReturn("System");
    when(instance.externalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).externalId();
    verify(instance).system();
    ImmutableExternalIdentifier buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("System", buildResult.system());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdentifier)} with {@code ExternalIdentifier}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdentifier)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdentifier) with 'ExternalIdentifier'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdentifier)"})
  void testBuilderFromWithExternalIdentifier_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ExternalIdentifier instance = mock(ExternalIdentifier.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.system()).thenReturn("System");
    when(instance.externalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).externalId();
    verify(instance).system();
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   * <ul>
   *   <li>Given {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'; given EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_givenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
  }

  /**
   * Test Builder {@link Builder#system(String)}.
   * <p>
   * Method under test: {@link Builder#system(String)}
   */
  @Test
  @DisplayName("Test Builder system(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.system(String)"})
  void testBuilderSystem() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.system("System"));
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setSystem(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setEntityReference(EntityReference)",
      "void Json.setExternalId(String)", "void Json.setSystem(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(null);
    actualJson.setExternalId("42");
    actualJson.setSystem("System");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("System", actualJson.system);
    assertNull(actualJson.entityReference);
  }

  /**
   * Test Json {@link Json#system()}.
   * <p>
   * Method under test: {@link Json#system()}
   */
  @Test
  @DisplayName("Test Json system()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.system()"})
  void testJsonSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).system());
  }
}
