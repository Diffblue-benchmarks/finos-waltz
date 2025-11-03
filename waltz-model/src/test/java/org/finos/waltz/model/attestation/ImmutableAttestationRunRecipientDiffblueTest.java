package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.attestation.ImmutableAttestationRunRecipient.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationRunRecipient.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunRecipientDiffblueTest {
  /**
   * Test Builder {@link Builder#completedCount(long)}.
   * <p>
   * Method under test: {@link Builder#completedCount(long)}
   */
  @Test
  @DisplayName("Test Builder completedCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.completedCount(long)"})
  void testBuilderCompletedCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completedCount(3L));
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunRecipient)} with {@code AttestationRunRecipient}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationRunRecipient)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunRecipient) with 'AttestationRunRecipient'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationRunRecipient)"})
  void testBuilderFromWithAttestationRunRecipient_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    AttestationRunRecipient instance = mock(AttestationRunRecipient.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.userId()).thenReturn("42");
    when(instance.completedCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).completedCount();
    verify(instance).pendingCount();
    verify(instance).totalCount();
    verify(instance).userId();
    ImmutableAttestationRunRecipient buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(3L, buildResult.completedCount());
    assertEquals(3L, buildResult.pendingCount());
    assertEquals(3L, buildResult.totalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunRecipient)} with {@code AttestationRunRecipient}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationRunRecipient)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunRecipient) with 'AttestationRunRecipient'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationRunRecipient)"})
  void testBuilderFromWithAttestationRunRecipient_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    AttestationRunRecipient instance = mock(AttestationRunRecipient.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.userId()).thenReturn("42");
    when(instance.completedCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).completedCount();
    verify(instance).pendingCount();
    verify(instance).totalCount();
    verify(instance).userId();
    ImmutableAttestationRunRecipient buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(3L, buildResult.completedCount());
    assertEquals(3L, buildResult.pendingCount());
    assertEquals(3L, buildResult.totalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunRecipient)} with {@code AttestationRunRecipient}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationRunRecipient)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunRecipient) with 'AttestationRunRecipient'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationRunRecipient)"})
  void testBuilderFromWithAttestationRunRecipient_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    AttestationRunRecipient instance = mock(AttestationRunRecipient.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");
    when(instance.completedCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).completedCount();
    verify(instance).pendingCount();
    verify(instance).totalCount();
    verify(instance).userId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#pendingCount(long)}.
   * <p>
   * Method under test: {@link Builder#pendingCount(long)}
   */
  @Test
  @DisplayName("Test Builder pendingCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.pendingCount(long)"})
  void testBuilderPendingCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.pendingCount(3L));
  }

  /**
   * Test Builder {@link Builder#totalCount(long)}.
   * <p>
   * Method under test: {@link Builder#totalCount(long)}
   */
  @Test
  @DisplayName("Test Builder totalCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.totalCount(long)"})
  void testBuilderTotalCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.totalCount(3L));
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   * <p>
   * Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Test Json {@link Json#completedCount()}.
   * <p>
   * Method under test: {@link Json#completedCount()}
   */
  @Test
  @DisplayName("Test Json completedCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.completedCount()"})
  void testJsonCompletedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).completedCount());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
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
    assertNull(actualJson.userId);
    assertEquals(0L, actualJson.completedCount);
    assertEquals(0L, actualJson.pendingCount);
    assertEquals(0L, actualJson.totalCount);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.completedCountIsSet);
    assertFalse(actualJson.pendingCountIsSet);
    assertFalse(actualJson.totalCountIsSet);
  }

  /**
   * Test Json {@link Json#pendingCount()}.
   * <p>
   * Method under test: {@link Json#pendingCount()}
   */
  @Test
  @DisplayName("Test Json pendingCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.pendingCount()"})
  void testJsonPendingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).pendingCount());
  }

  /**
   * Test Json {@link Json#setCompletedCount(long)}.
   * <p>
   * Method under test: {@link Json#setCompletedCount(long)}
   */
  @Test
  @DisplayName("Test Json setCompletedCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCompletedCount(long)"})
  void testJsonSetCompletedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCompletedCount(3L);

    // Assert
    assertEquals(3L, json.completedCount);
    assertTrue(json.completedCountIsSet);
  }

  /**
   * Test Json {@link Json#setPendingCount(long)}.
   * <p>
   * Method under test: {@link Json#setPendingCount(long)}
   */
  @Test
  @DisplayName("Test Json setPendingCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPendingCount(long)"})
  void testJsonSetPendingCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPendingCount(3L);

    // Assert
    assertEquals(3L, json.pendingCount);
    assertTrue(json.pendingCountIsSet);
  }

  /**
   * Test Json {@link Json#setTotalCount(long)}.
   * <p>
   * Method under test: {@link Json#setTotalCount(long)}
   */
  @Test
  @DisplayName("Test Json setTotalCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setTotalCount(long)"})
  void testJsonSetTotalCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTotalCount(3L);

    // Assert
    assertEquals(3L, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Test Json {@link Json#totalCount()}.
   * <p>
   * Method under test: {@link Json#totalCount()}
   */
  @Test
  @DisplayName("Test Json totalCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.totalCount()"})
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).totalCount());
  }

  /**
   * Test Json {@link Json#userId()}.
   * <p>
   * Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userId());
  }
}
