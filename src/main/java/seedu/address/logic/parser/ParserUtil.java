package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.item.Metric;
import seedu.address.model.item.Name;
import seedu.address.model.item.Quantity;
import seedu.address.model.item.Supplier;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String quantity} into a {@code Quantity}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code quantity} is invalid.
     */
    public static Quantity parseQuantity(String quantity) throws ParseException {
        requireNonNull(quantity);
        String trimmedQuantity = quantity.trim();
        if (!Quantity.isValidQuantity(trimmedQuantity)) {
            throw new ParseException(Quantity.MESSAGE_CONSTRAINTS);
        }
        return new Quantity(trimmedQuantity);
    }

    /**
     * Parses a {@code String supplier} into an {@code Supplier}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code Supplier} is invalid.
     */
    public static Supplier parseSupplier(String supplier) throws ParseException {
        requireNonNull(supplier);
        String trimmedSupplier = supplier.trim();
        if (!Supplier.isValidSupplier(trimmedSupplier)) {
            throw new ParseException(Supplier.MESSAGE_CONSTRAINTS);
        }
        return new Supplier(trimmedSupplier);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses {@code String maxQuantity} into a {@code Quantity}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code quantity} is invalid.
     */

    public static Quantity parseMaxQuantity(String quantity) throws ParseException {
        requireNonNull(quantity);
        String trimmedQuantity = quantity.trim();
        if (!Quantity.isValidMaxQuantity(trimmedQuantity)) {
            throw new ParseException(Quantity.MESSAGE_CONSTRAINTS_MAX_QUANTITY);
        }
        return new Quantity(trimmedQuantity);
    }

    /**
     * Parses a {@code String metric} into an {@code Metric}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code Metric} is invalid.
     */
    public static Metric parseMetric(String metric) throws ParseException {
        requireNonNull(metric);
        String trimmedMetric = metric.trim();
        if (!Metric.isValidMetric(metric)) {
            throw new ParseException(Metric.MESSAGE_CONSTRAINTS);
        }
        return new Metric(trimmedMetric);
    }

}
