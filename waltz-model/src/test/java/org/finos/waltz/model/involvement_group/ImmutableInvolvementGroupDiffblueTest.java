package org.finos.waltz.model.involvement_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementGroupDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInvolvementGroup#builder()}
   *   <li>{@link ImmutableInvolvementGroup#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableInvolvementGroup.Builder actualIdResult = ImmutableInvolvementGroup.builder().id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableInvolvementGroup.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroup.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test: {@link ImmutableInvolvementGroup.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableInvolvementGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementGroup.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableInvolvementGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementGroup.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroup.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroup.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroup.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableInvolvementGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroup.Builder#from(InvolvementGroup)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    InvolvementGroup instance = mock(InvolvementGroup.class);
    when(instance.externalId()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).externalId();
    ImmutableInvolvementGroup buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroup.Builder#from(InvolvementGroup)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    InvolvementGroup instance = mock(InvolvementGroup.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroup.Builder#from(InvolvementGroup)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    InvolvementGroup instance = mock(InvolvementGroup.class);
    when(instance.externalId()).thenReturn("42");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).externalId();
    ImmutableInvolvementGroup buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementGroup.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableInvolvementGroup.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableInvolvementGroup.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableInvolvementGroup.Builder builderResult = ImmutableInvolvementGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableInvolvementGroup#copyOf(InvolvementGroup)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InvolvementGroup instance = mock(InvolvementGroup.class);
    when(instance.externalId()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementGroup actualCopyOfResult = ImmutableInvolvementGroup.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).externalId();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
  }

  /**
   * Method under test: {@link ImmutableInvolvementGroup#copyOf(InvolvementGroup)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    InvolvementGroup instance = mock(InvolvementGroup.class);
    when(instance.externalId()).thenReturn("42");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementGroup actualCopyOfResult = ImmutableInvolvementGroup.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).externalId();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
  }
}
